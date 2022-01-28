
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;


public class inTakeIn extends CommandBase {
  /** Creates a new inTakeIn. */
  public final intake m_intake;

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color blueTarget = new Color(0.2,0.45,0.34);
  private final Color redTarget = new Color(0.4, 0.4, 0.2);
  double IR = m_colorSensor.getIR();
  String colorString;
  
  //private final Color blueTarget = ColorMatch.Color(0.14,0.42,0.42);
  public inTakeIn(intake intake_subsystem) {
    m_intake = intake_subsystem;
    addRequirements(m_intake);

    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    Color detectedColor = m_colorSensor.getColor();
    double proximity = m_colorSensor.getProximity();
    SmartDashboard.putNumber("red", detectedColor.red);
    SmartDashboard.putNumber("green", detectedColor.green);
    SmartDashboard.putNumber("blue", detectedColor.blue);
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (proximity < 400){
      if (detectedColor.red > detectedColor.blue){
        colorString = "Red";
  
      }
      else if (detectedColor.red < detectedColor.blue){
        colorString = "Blue";
      }
  
    }

   


    DriverStation.reportWarning("color"+ colorString, false);
    //double IR = m_colorSensor.getIR();
    
   // SmartDashboard.putNumber("Red", detectedColor.red);
    //SmartDashboard.putNumber("Blue", detectedColor.blue);
    m_intake.IntakeIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
