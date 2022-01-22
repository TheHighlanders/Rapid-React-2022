// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import java.util.concurrent.TimeoutException;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveBackCMD extends CommandBase {
  /** Creates a new DriveBack. */
  public final DriveTrain m_ddriveTrain;
  public Timer m_Timer;
  public DriveBackCMD(DriveTrain drive_subsystem) {
   m_ddriveTrain = drive_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(m_ddriveTrain);
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
 
    if(m_Timer.get() < 3 ) { 
       m_ddriveTrain.drivepower(0.2, 0.2); 
    }
    else{ 
      m_ddriveTrain.drivepower(0, 0); 
      m_Timer.stop();

    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
