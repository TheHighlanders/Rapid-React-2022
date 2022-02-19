
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.revrobotics.ColorSensorV3;

import frc.robot.OI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;


public class inTakeInCMD extends CommandBase {
  /** Creates a new inTakeIn. */
  public final intake m_intake;
  
  public final OI m_OI;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  double IR = m_colorSensor.getIR();
  String colorString;
  
  public inTakeInCMD(intake intake_subsystem, OI OI_xbox) {
    m_intake = intake_subsystem;
    m_OI = OI_xbox;
    addRequirements(m_intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    DriverStation.Alliance Alliancecolor = DriverStation.getAlliance();
    Color detectedColor = m_colorSensor.getColor();
    double proximity = m_colorSensor.getProximity();

    DriverStation.reportWarning("distance" + proximity, false);
    if (proximity > 300 && proximity < 2047){ //if the ball is in range
      if (detectedColor.red > detectedColor.blue){ // if the red color value is greater than the blue color value
        colorString = "Red"; 
        SmartDashboard.putBoolean("cargo", true); //some dashboard feedback       

  
      }
      else if (detectedColor.red < detectedColor.blue){
        colorString = "Blue";
        SmartDashboard.putBoolean("cargo", false);       
      }
      else{
        execute(); //just in case the neither of the if statments trigger
      }

      DriverStation.reportWarning("color "+ colorString +" Alliance "+  DriverStation.getAlliance(), false);
      
      if (!colorString.equals(Alliancecolor.toString())){ //check if the ball is the color of our alliance
        m_OI.setxboxrumble(1,1); //set the controller to rumbleif wrong color
      }
    }
    m_intake.ascend();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}