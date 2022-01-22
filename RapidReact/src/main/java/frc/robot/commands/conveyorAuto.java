// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.conveyor;

public class conveyorAuto extends CommandBase {
  /** Creates a new conveyorAuto. */
  public final conveyor m_Conveyor;
  public Timer m_Timer;
  public conveyorAuto(conveyor conveyor_subsystem) {
    m_Conveyor = conveyor_subsystem;
    addRequirements(m_Conveyor);
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
    if (m_Timer.get() <3) {
      m_Conveyor.ascendleft();
      m_Conveyor.ascendright();
    } else {
      m_Conveyor.stopleft();
      m_Conveyor.stopright();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Conveyor.stopleft();
    m_Conveyor.stopright();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}