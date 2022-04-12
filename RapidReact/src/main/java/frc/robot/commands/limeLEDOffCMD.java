package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpoinkVision;
import edu.wpi.first.wpilibj.Timer;

public class limeLEDOffCMD extends CommandBase {
  /** Creates a new limeLEDOnCMD. */
  public SpoinkVision m_Vision;
  boolean isFinished = false;
  public Timer m_Timer;
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  

  public limeLEDOffCMD(SpoinkVision vision_sub) {
    m_Vision = vision_sub;
    addRequirements(m_Vision);
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
    DriverStation.reportWarning("LEDs Going Off", false);
    m_Vision.limelightOff();
      isFinished = true;
    //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3)
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