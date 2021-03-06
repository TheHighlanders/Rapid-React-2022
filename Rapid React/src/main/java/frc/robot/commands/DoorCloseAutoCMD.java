// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Door;

public class DoorCloseAutoCMD extends CommandBase {
  /** Creates a new DoorOpenAutoCMD. */
    /** Creates a new DoorCMD. */
    public final Door m_door;
    public Timer m_Timer;
    boolean isFinished = false;
    
    public DoorCloseAutoCMD(Door door_subsystem) {
      m_door = door_subsystem;
      // addRequirements(m_door);
    } 
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      m_door.openDoor();
      isFinished = true;
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      //m_door.openDoor();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return isFinished;
    }
  }