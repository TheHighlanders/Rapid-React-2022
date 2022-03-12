// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.*;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Door;
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
  public final Climber m_climber = new Climber();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_door.Door.setSelectedSensorPosition(0);
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
    JoystickButton inTakein = new JoystickButton(m_OI.xbox, 1); //A
    inTakein.whileHeld(new inTakeInCMD(m_intake,m_OI));

    JoystickButton intakeoutCMD = new JoystickButton(m_OI.xbox, 2); // B
    intakeoutCMD.whileHeld(new intakeoutCMD(m_intake));

    JoystickButton DoorOpen = new JoystickButton(m_OI.xbox, 3); // x
    DoorOpen.whileHeld(new DoorOpenCMD(m_door));

    // JoystickButton DoorCenter = new JoystickButton(m_OI.xbox, 4); // Y
    // // DoorOpen.whileHeld(new DoorCenterCMD(m_door));

    //JoystickButton AutoRun = new JoystickButton(m_OI.xbox,4); // y
    //AutoRun.whileHeld(new AutoGroupCMD(m_ddriveTrain, m_intake));

    // climbing

    JoystickButton BigArmsForward = new JoystickButton(m_OI.xboxClimb,1); // a
    BigArmsForward.whileHeld(new DadMotorUpCMD(m_climber,m_OI));

    JoystickButton BigArmsBack = new JoystickButton(m_OI.xboxClimb,4); // y
    BigArmsBack.whileHeld(new DadMotorDownCMD(m_climber,m_OI));

    JoystickButton SmallArmsBack = new JoystickButton(m_OI.xboxClimb,5); // LB
    SmallArmsBack.whileHeld(new BabyMotorDownCMD(m_climber,m_OI));


    POVButton SmallArmsForward = new POVButton(m_OI.xboxClimb,180); // X
    SmallArmsForward.whileHeld(new BabyMotorUpCMD(m_climber,m_OI));

    

    // POVButton smallArmsUp2 = new POVButton(m_OI.xboxClimb, 315);
    // smallArmsUp2.whileHeld(new BabyClimberUpCMD(m_climber, m_OI));

    // POVButton smallArmsUp3 = new POVButton(m_OI.xboxClimb, 45);
    // smallArmsUp3.whileHeld(new BabyClimberUpCMD(m_climber, m_OI));

    // // ALL SMALL ARMS DOWN BUTTONS
    // POVButton smallArmsDown = new POVButton(m_OI.xboxClimb, 180);
    // smallArmsDown.whileHeld(new BabyClimberDownCMD(m_climber, m_OI));

    // POVButton smallArmsDown1 = new POVButton(m_OI.xboxClimb, 225);
    // smallArmsDown1.whileHeld(new BabyClimberDownCMD(m_climber, m_OI));

    // POVButton smallArmsDown2 = new POVButton(m_OI.xboxClimb, 135);
    // smallArmsDown2.whileHeld(new BabyClimberDownCMD(m_climber, m_OI));
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
