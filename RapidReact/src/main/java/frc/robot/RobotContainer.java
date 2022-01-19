// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoGroupCMD;
import frc.robot.commands.ascendCMD;
import frc.robot.commands.descendCMD;
import frc.robot.commands.driveCMD;
import frc.robot.commands.inTakeIn;
import frc.robot.commands.intakeoutCMD;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.conveyor;
import frc.robot.subsystems.intake;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_dDrivetrain = new DriveTrain();
  private final OI m_OI = new OI();
  private final conveyor m_Conveyor = new conveyor();
  private final intake m_intake = new intake();
  private Command m_autoCommand;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_dDrivetrain.setDefaultCommand(new driveCMD(m_dDrivetrain, m_OI));
    m_autoCommand = new AutoGroupCMD(m_dDrivetrain, m_Conveyor);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // JoystickButton name = new JoystickButton(m_OI.xbox, #);
    // name.whileHeld(new commmandname(m_Conveyor));
    JoystickButton inTakeIn = new JoystickButton(m_OI.xbox, 1);
    inTakeIn.whileHeld(new inTakeIn(m_intake));

    JoystickButton intakeoutCMD = new JoystickButton(m_OI.xbox, 2);
    intakeoutCMD.whileHeld(new intakeoutCMD(m_intake));

    JoystickButton ascendCMD = new JoystickButton(m_OI.xbox, 3);
    ascendCMD.whileHeld(new ascendCMD(m_Conveyor));

    JoystickButton descendCMD = new JoystickButton(m_OI.xbox, 4);
    descendCMD.whileHeld(new descendCMD(m_Conveyor));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
