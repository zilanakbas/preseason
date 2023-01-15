// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsytem extends SubsystemBase {
  /** Creates a new ShooterSubsytem. */

    private final WPI_TalonFX shooterMotor = new WPI_TalonFX(ShooterConstants.kshooterMotorPort);
  public ShooterSubsytem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
