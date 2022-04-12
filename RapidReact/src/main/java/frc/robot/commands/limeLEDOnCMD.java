package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpoinkVision;

public class limeLEDOnCMD extends CommandBase {
  /** Creates a new limeLEDOnCMD. */
  public SpoinkVision m_Vision;
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  boolean isFinished = false;

  public limeLEDOnCMD(SpoinkVision vision_sub) {
    m_Vision = vision_sub;
    addRequirements(m_Vision);
    SmartDashboard.putBoolean("Vision Running", true);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Vision.limelightOn();
    //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
    isFinished = true;
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