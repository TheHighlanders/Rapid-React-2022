// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.SpoinkVision;
import frc.robot.subsystems.spoinkVision2;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Door;
import frc.robot.subsystems.intake;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class NewAutoDCMPCMDGrp extends SequentialCommandGroup {
  /** Creates a new NewAutoDCMPCMDGrp. */
  public NewAutoDCMPCMDGrp(DriveTrain m_dDriveTrain, intake m_intake, Door m_door, spoinkVision2 m_vision2, SpoinkVision m_vision) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveForwardIntakeAutoCMD(m_intake, m_dDriveTrain),
      new DriveTurn180CMD(m_dDriveTrain),
      new AUTONVisionShootingSequenceCMDGroup(m_dDriveTrain, m_intake, m_door, m_vision2, m_vision),
      new DriveBackCMD(m_dDriveTrain)

    );
  }
}
