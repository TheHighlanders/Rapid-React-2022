// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Climber;


public class DadMotorDownCMD extends CommandBase {
  /** Creates a new ClimberCMD. */
  public final Climber m_cClimber;
  public final OI m_OI;

  public DadMotorDownCMD(Climber Climber_subsystem, OI OI_climbXbox) {
    m_cClimber = Climber_subsystem;
    m_OI = OI_climbXbox;
    addRequirements(m_cClimber);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_cClimber.SetDadMotorDown();
    //m_cClimber.SetBabyMotorPower();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_cClimber.SetDadMotorHold();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
