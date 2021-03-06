// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;

public class IntakeArmInCMD extends CommandBase {
  /** Creates a new IntakeArmInCMD. */
  public final intake m_intakearm;

  public IntakeArmInCMD(intake intakesub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakearm = intakesub; 
    addRequirements(m_intakearm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakearm.intakeIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakearm.stopintake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
