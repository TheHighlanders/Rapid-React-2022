// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoGroupCMD;
//import frc.robot.commands.DoorCloseCMD;
//import frc.robot.commands.DoorOpenCMD; add in imports when merged with a branch with door code
import frc.robot.commands.driveCMD;
//import frc.robot.commands.inTakeIn;
import frc.robot.commands.intakeoutCMD;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.intake;
//import frc.robot.subsystems.Door;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_ddriveTrain = new DriveTrain();
  private final OI m_OI = new OI();
  private final intake m_intake = new intake();
  private Command m_autoCommand;
  public final Door m_door = new Door();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_ddriveTrain.setDefaultCommand(new driveCMD(m_ddriveTrain, m_OI));
    m_autoCommand = new AutoGroupCMD(m_ddriveTrain, m_intake);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // JoystickButton name = new JoystickButton(m_OI.xbox, #);
    // name.whileHeld(new commmandname(m_intake));
    JoystickButton inTakeIn = new JoystickButton(m_OI.xbox, 1);
    inTakeIn.whileHeld(new inTakeIn(m_intake,m_OI));

    JoystickButton intakeoutCMD = new JoystickButton(m_OI.xbox, 2);
    intakeoutCMD.whileHeld(new intakeoutCMD(m_intake));

    JoystickButton DoorOpen = new JoystickButton(m_OI.xbox, 5);
    DoorOpen.whileHeld(new DoorOpenCMD(m_door));

    JoystickButton DoorClosed = new JoystickButton(m_OI.xbox,6); // change number button when needed
    DoorClosed.whileHeld(new DoorCloseCMD(m_door));

    JoystickButton AutoRun = new JoystickButton(m_OI.xbox,4);
    AutoRun.whileHeld(new AutoGroupCMD(m_ddriveTrain, m_intake));
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
