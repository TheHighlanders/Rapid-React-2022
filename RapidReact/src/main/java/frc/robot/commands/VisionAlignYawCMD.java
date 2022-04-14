package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.spoinkVision2;

public class VisionAlignYawCMD extends CommandBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public final spoinkVision2 m_vision;
  public final DriveTrain m_dDriveTrain; 
  boolean finished = false;
  /** Creates a new VisionAlignYawCMD. */
  public VisionAlignYawCMD(spoinkVision2 vision_sub, DriveTrain  drive_sub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_vision = vision_sub;
    m_dDriveTrain = drive_sub;
    addRequirements(m_vision,m_dDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ta = table.getEntry("ta");
    double taDoub = ta.getDouble(0);
    NetworkTableEntry tv = table.getEntry("tv");
    double tvDoub = ta.getDouble(0);
    double TargetOffsetYaw = tx.getDouble(0.0);
    double MaxYaw = 5;
    double MinYaw = -5;
    if(tvDoub==1){
    if(TargetOffsetYaw > MaxYaw){
      DriverStation.reportWarning("Turning Left", false);
      m_dDriveTrain.drivepower(0.15, 0.15);
      finished = false;

    }
    if(TargetOffsetYaw < MinYaw) {
      DriverStation.reportWarning("Turning Right", false);
      m_dDriveTrain.drivepower(-0.15, -0.15);
      finished = false;
    }
    if(TargetOffsetYaw < MaxYaw && TargetOffsetYaw > MinYaw) {
      DriverStation.reportWarning("Centered", false);
      m_dDriveTrain.drivepower(0, 0);
      finished = true;
    }
  }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}