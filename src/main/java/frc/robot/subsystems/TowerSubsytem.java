// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TowerConstants;

public class TowerSubsytem extends SubsystemBase {
  /** Creates a new TowerSubsytem. */

  private final WPI_TalonFX towerMotor = new WPI_TalonFX(TowerConstants.ktowerMotorPort, "Default Name");
  private final WPI_TalonFX outtakeMotor = new WPI_TalonFX(TowerConstants.kouttakeMotorPort, "Default Name");
  private final CANSparkMax shooterfeederMotor = new CANSparkMax(TowerConstants.kfeederMotorPort,MotorType.kBrushless);
  private final DigitalInput beamBrake1 = new DigitalInput(0);
  private final DigitalInput beamBrake2 = new DigitalInput(3);
  public boolean firstBallhasSeen = false;
  public boolean secondBallhasSeen = false;
  private boolean beamBreak1State, beamBreak2State = false;
 // private final WPI_TalonFX feederMotor = new WPI_TalonFX(TowerConstants.kfeederMotorPort, "Default Name");
  
  public TowerState towerState = TowerState.IDLE;
  public BallState ballState = BallState.ZEROBALL;

  public enum TowerState{
    INTAKE ,
    OUTTAKE ,
    IDLE,
    FEED
  }

  public enum BallState{
    ZEROBALL,
    ONEBALL,
    TWOBALLS,
    ONHOLD,
    LIMIT
  }

  



  public TowerSubsytem() {}

  @Override
  public void periodic() {
    beamBreak1State = !beamBrake1.get();
    beamBreak2State = !beamBrake2.get();
    SmartDashboard.putBoolean("State1", beamBreak1State);
    SmartDashboard.putBoolean("State2", beamBreak2State);
    
      switch(ballState){
        case ZEROBALL:
          SmartDashboard.putString("Ball Count", "ONEBALL");
          if(beamBreak1State){
            boolean isInHold = true;
            while(isInHold){
              isInHold = beamBreak1State;
              beamBreak1State = !beamBrake1.get();
              beamBreak2State = !beamBrake2.get();
              SmartDashboard.putBoolean("State1", beamBreak1State);
              SmartDashboard.putBoolean("State2", beamBreak2State);
            }
            setBallState(ballState.ONEBALL); 
          }
        break;
        case ONEBALL:
          setBallState(BallState.TWOBALLS);
          SmartDashboard.putString("Ball Count", "TWOBALL");
          if(beamBreak1State){
            boolean isInHold = true;
            while(isInHold){
              isInHold = beamBreak1State;
              beamBreak1State = !beamBrake1.get();
              beamBreak2State = !beamBrake2.get();
              SmartDashboard.putBoolean("State1", beamBreak1State);
              SmartDashboard.putBoolean("State2", beamBreak2State);
            }
            setBallState(ballState.TWOBALLS); 
          }
        break;
        case TWOBALLS:
        SmartDashboard.putString("Ball Count", "LIMIT");
        SmartDashboard.putString("Ball Count", "TWOBALL");
          if(beamBreak1State){
            boolean isInHold = true;
            while(isInHold){
              isInHold = beamBreak1State;
              beamBreak1State = !beamBrake1.get();
              beamBreak2State = !beamBrake2.get();
              SmartDashboard.putBoolean("State1", beamBreak1State);
              SmartDashboard.putBoolean("State2", beamBreak2State);
            }
            setBallState(ballState.LIMIT); 
          }
          
        break;
      }
    // This method will be called once per scheduler run
  }
  
  public void outtake(double speed) {
    outtakeMotor.set(speed);
  }
  public void index(double speed) {
    towerMotor.set(speed);
    
  }
   public void feeder(double speed) {
    //feederMotor.set(speed);
  }
  public void setBallState(BallState inputBallState) {
      ballState = inputBallState;
  }
  public BallState getBallState() {
      return ballState;
  }


  
 
  

  

  }


