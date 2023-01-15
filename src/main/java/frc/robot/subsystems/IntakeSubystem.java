package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



public class IntakeSubystem extends SubsystemBase{
    private final WPI_TalonFX intakeMotor = new WPI_TalonFX(IntakeConstants.kintakeMotorPort, "Default Name");
    private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,IntakeConstants.kdoubleSolenoidPin1,IntakeConstants.kdoubleSolenoidPin2);

    public IntakeState intakeState = IntakeState.CLOSE;

    public enum IntakeState {
        RUN,
        CLOSE
    }

   public IntakeSubystem() {
       compressor.enableDigital();
   }

    public void runIntake(double speed) {
        intakeMotor.set(speed);
    }

    public void openCompressor() {
        compressor.enableDigital();
    }

    public void closeCompressor() {
        compressor.disable();
    }

    public void intakeUp() {
        intakeSolenoid.set(Value.kForward);
    }

    public void intakeDown() {
        intakeSolenoid.set(Value.kReverse);
    }

    





}



