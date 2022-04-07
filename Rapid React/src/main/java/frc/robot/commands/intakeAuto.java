// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake;

public class intakeAuto extends CommandBase {
  /** Creates a new intakeAuto. */
  public final intake m_intake;
  public Timer m_Timer;
  boolean isFinished = false;

  public intakeAuto(intake intake_subsystem) {
    m_intake = intake_subsystem;
    addRequirements(m_intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override

  public void initialize() {
    m_Timer = new Timer();
    m_Timer.reset();
    m_Timer.start();
    isFinished=false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_Timer.get() < 2) {
      m_intake.asecendAuto();
      DriverStation.reportError("Shooting cargo", false);
      isFinished=false;
    } else {
      m_intake.intakeStopAuto();
      isFinished = true;
      DriverStation.reportError("DONE Shooting cargo", false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   m_intake.intakeStopAuto();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    DriverStation.reportError("FINISHED Shooting cargo", false);
    return isFinished;
  }
}