// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.tower;

import frc.robot.subsystems.TowerSubsytem;
import frc.robot.subsystems.TowerSubsytem.TowerState;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexCommand extends CommandBase {
  /** Creates a new IndexCommand. */
  private TowerSubsytem m_towerSubsytem;
  
  public IndexCommand(TowerSubsytem towerSubsytem) {

    m_towerSubsytem = towerSubsytem;
    addRequirements(towerSubsytem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_towerSubsytem.towerState = TowerState.INTAKE;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_towerSubsytem.index(0.5);
    m_towerSubsytem.outtake(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_towerSubsytem.index(0);
    m_towerSubsytem.outtake(0);
    m_towerSubsytem.feeder(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
