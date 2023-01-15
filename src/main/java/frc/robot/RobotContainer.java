// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.tower.IndexCommand;
import frc.robot.commands.tower.OuttakeCommand;
import frc.robot.subsystems.IntakeSubystem;
import frc.robot.subsystems.TowerSubsytem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  

  private final IntakeSubystem m_intakeSubystem = new IntakeSubystem();
  private final TowerSubsytem m_TowerSubsytem = new TowerSubsytem();
  private final XboxController joystick = new XboxController(JoystickConstants.kDriverJoystickPort);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(joystick, 6).whileHeld(new IntakeCommand(m_intakeSubystem));
    new JoystickButton(joystick, 1).whileHeld(new IndexCommand(m_TowerSubsytem));
    new JoystickButton(joystick, 2).whileHeld(new OuttakeCommand(m_TowerSubsytem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
