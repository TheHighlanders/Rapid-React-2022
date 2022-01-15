// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  PowerDistribution left2PD = new PowerDistribution(0, ModuleType.kCTRE);
  //PowerDistribution right1PD = new PowerDistribution(0, ModuleType.kCTRE);
  
  public Timer m_Timer;
  
  public WPI_VictorSPX left1;
  public WPI_TalonSRX left2;
  public WPI_TalonSRX right1;
  public WPI_VictorSPX right2;
  
  private double ramp = 0.2;

  public DriveTrain() {
    left1= new WPI_VictorSPX(Constants.LEFT_ONE);
    left2 = new WPI_TalonSRX(Constants.LEFT_TWO);
    right1 = new WPI_TalonSRX(Constants.RIGHT_ONE);
    right2 = new WPI_VictorSPX(Constants.RIGHT_TWO);

    left1.configOpenloopRamp(ramp,0);
    left2.configOpenloopRamp(ramp,0);
    right1.configOpenloopRamp(ramp,0);
    right2.configOpenloopRamp(ramp,0);

    left1.setNeutralMode(NeutralMode.Coast);
    left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    right2.setNeutralMode(NeutralMode.Coast);

    left2.follow(left1);
    right2.follow(right1);

    m_Timer = new Timer();
    m_Timer.reset();
    m_Timer.start();

  }

  public void drivepower(double left_power, double right_power){
      left1.set(left_power);
      right1.set(right_power);

  }
  public double getOutputCurrentL(){
     return left2PD.getCurrent(12);

  }

 // public double getOutputCurrentR(){
 // return right1PD.getCurrent(2);

 // }

//  public void driveBack(){
//     if(m_Timer.get() < 1 ) { 
//         drivepower(-0.1, -0.1); 
//   }
//   else{ 
//     drivepower(0, 0); 
//     m_Timer.stop();

//   }
//  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
