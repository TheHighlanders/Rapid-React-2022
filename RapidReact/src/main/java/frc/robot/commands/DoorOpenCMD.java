// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Door;
import edu.wpi.first.wpilibj.Timer;

public class DoorOpenCMD extends CommandBase {
  /** Creates a new DoorCMD. */
  public Timer m_Timer;
  public final Door m_door;
  public final double open_time=0.2,close_time=0.5;
  public DoorOpenCMD(Door door_subsystem) {
    m_door = door_subsystem;
    // addRequirements(m_door);
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
    if(m_Timer.get()%(open_time + close_time)<open_time){

  
    m_door.closeDoor();
    }
    else{m_door.openDoor();}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     m_door.openDoor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
