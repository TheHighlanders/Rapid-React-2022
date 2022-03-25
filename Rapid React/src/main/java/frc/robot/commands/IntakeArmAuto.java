// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;

public class IntakeArmAuto extends CommandBase {
  public final intake m_iIntake;
  public Timer m_Timer;
  boolean isFinished = false;

  /** Creates a new IntakeArmAuto. */
  public IntakeArmAuto(intake intake_subsystem) {
    m_iIntake = intake_subsystem;
    addRequirements(m_iIntake);
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
    if(m_Timer.get() < 3 ) { 
      m_iIntake.autoIntake();
   }
   else{ 
     m_iIntake.stopintake(); 
     m_Timer.stop();
     isFinished = true;

   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
