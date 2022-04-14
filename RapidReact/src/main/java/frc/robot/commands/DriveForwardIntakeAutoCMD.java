// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.intake;

public class DriveForwardIntakeAutoCMD extends CommandBase {
  public final DriveTrain m_ddriveTrain;
  public final intake m_intake; 
  public Timer m_Timer;
  boolean finished = false;
  /** Creates a new DriveForwardIntakeAutoCMD. */
  public DriveForwardIntakeAutoCMD(intake intake_subsystem, DriveTrain drive_subsystem) {
    m_intake = intake_subsystem;
    m_ddriveTrain = drive_subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intake, m_ddriveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer = new Timer();
    m_Timer.reset();
    m_Timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_Timer.get() < 1 ) { 
      m_ddriveTrain.drivepower(0.6, -0.6);
      m_intake.asecendAuto();
      finished = false;
   }
   else{ 
     m_ddriveTrain.drivepower(0, 0); 
     m_Timer.stop();
    finished = true;
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
