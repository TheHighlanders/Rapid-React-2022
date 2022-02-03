
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import frc.robot.OI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.conveyor;


public class inTakeIn extends CommandBase {
  /** Creates a new inTakeIn. */
  public final conveyor m_conveyor;
  
  public final OI m_OI;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  double IR = m_colorSensor.getIR();
  String colorString;
 // DriverStation.Alliance Alliancecolor;// = DriverStation.getAlliance();
  
  public inTakeIn(conveyor conveyor_subsystem, OI OI_xbox) {
    m_conveyor = conveyor_subsystem;
    m_OI = OI_xbox;
    addRequirements(m_conveyor);

    
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
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    DriverStation.reportWarning("distance" + proximity, false);
    if (proximity > 300 && proximity < 2047){
      if (detectedColor.red > detectedColor.blue){
        colorString = "Red";
        SmartDashboard.putBoolean("cargo", true);       

  
      }
      else if (detectedColor.red < detectedColor.blue){
        colorString = "Blue";
        SmartDashboard.putBoolean("cargo", false);       
      }
      DriverStation.reportWarning("color "+ colorString +" Alliance "+  DriverStation.getAlliance(), false);
      
      if (!colorString.equals(Alliancecolor.toString())){
        m_OI.setxboxrumble(1,1);
        DriverStation.reportWarning("rumble", false);
      }
    }
    m_conveyor.ascend();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_conveyor.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
