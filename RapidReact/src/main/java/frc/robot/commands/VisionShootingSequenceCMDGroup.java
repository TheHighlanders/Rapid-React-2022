// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.spoinkVision2;
import frc.robot.subsystems.Door;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SpoinkVision;
import frc.robot.subsystems.intake;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class VisionShootingSequenceCMDGroup extends SequentialCommandGroup {
  
  /** Creates a new VisionShootingSequenceCMDGroup. */
  public VisionShootingSequenceCMDGroup(DriveTrain m_dDriveTrain, intake m_intake, Door m_door, spoinkVision2 m_vision2, SpoinkVision m_vision) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new limeLEDOnCMD(m_vision),
    
      new VisionAlignYawCMD(m_vision2, m_dDriveTrain), 
      new VisionAlignDistanceCMD(m_vision, m_dDriveTrain), 
      new VisionAlignYawCMD(m_vision2, m_dDriveTrain),
      new intakeAuto(m_intake, m_door),
      new limeLEDOffCMD(m_vision),
      new WaitCMD(m_dDriveTrain)
      //amogus ඞ
    );
  
  }
}