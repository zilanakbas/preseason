// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubystem;
import frc.robot.subsystems.IntakeSubystem.IntakeState;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  private IntakeSubystem m_intakeSubsystem;
  public IntakeCommand(IntakeSubystem intakeSubystem) {

    m_intakeSubsystem = intakeSubystem;
    addRequirements(m_intakeSubsystem);


    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeSubsystem.intakeState = IntakeState.RUN;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   m_intakeSubsystem.runIntake(6.0);
   m_intakeSubsystem.intakeDown();
   

  

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.intakeUp();
    m_intakeSubsystem.runIntake(0);
    m_intakeSubsystem.intakeState = IntakeState.CLOSE;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

  }
}
