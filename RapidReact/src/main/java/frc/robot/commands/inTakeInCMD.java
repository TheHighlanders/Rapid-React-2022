
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import frc.robot.OI;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;

public class inTakeInCMD extends CommandBase {
  /** Creates a new inTakeIn. */
  public final intake m_intake; 
  public final OI m_OI;
 // private final I2C.Port i2cPort = I2C.Port.kOnboard;
 // private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
 private final DigitalInput color_in = new DigitalInput(1);
 private final DigitalInput prox_in = new DigitalInput(2);
 //double IR = m_colorSensor.getIR();
 // String colorString;
 // Boolean cargoColor; // Red when True, Blue when false
  
  public inTakeInCMD(intake intake_subsystem, OI OI_xbox) {
    m_intake = intake_subsystem;
    m_OI = OI_xbox;
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intake.ascend(); // runs the intake
   
    DriverStation.Alliance Alliancecolor = DriverStation.getAlliance(); // gets our alliance Color
    boolean detectedColor = color_in.get(); // true is blue false is red
    boolean proximity = prox_in.get(); // proximity 300 - 2047 is true evrything else is false
    
    boolean cargoColor = false;
    String colorString = "";

    SmartDashboard.putBoolean("Cargo Color", cargoColor); // Displays Cargo color to SmartDashBoard
    DriverStation.reportWarning("distance" + proximity, false); // prints out the proximity sensor's range (can be commented out after attached to intake)
    
    if (proximity){ // if the cargo is in range (300 will change once attached to the intake)
      if (!detectedColor){ // if the red color value is greater than the blue color value
        colorString = "Red"; // cargo is red
        cargoColor = true; // displays red
      }
      else if (detectedColor){ // if the red color value is less than the blue color value
        colorString = "Blue"; // cargo is blue
        cargoColor = false; // displays blue
      }

      SmartDashboard.putBoolean("Cargo Color", cargoColor); // Displays Cargo color to SmartDashBoard
      DriverStation.reportWarning("color "+ colorString +" Alliance "+  DriverStation.getAlliance(), false); // prints out cargo color and alliance color
      
      if (!colorString.equals(Alliancecolor.toString())){ // if the color is not equal to the alliance color therefore the wrong color
        m_OI.setxboxrumble(1,1); //set the controller to rumble
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.stop(); // sets intake motors to 0 so it stops once the command is done
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
