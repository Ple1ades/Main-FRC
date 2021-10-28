package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase{
    public WPI_VictorSPX m_leftFront = new WPI_VictorSPX(Constants.CAN.leftFront);
    public WPI_TalonFX m_leftBack = new WPI_TalonFX(Constants.CAN.leftBack);
    public SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftFront, m_leftBack);

    public WPI_VictorSPX m_rightFront = new WPI_VictorSPX(Constants.CAN.rightFront);
    public WPI_TalonFX m_rightBack = new WPI_TalonFX(Constants.CAN.rightBack);
    public SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightFront, m_rightBack);

    public DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    public boolean resetDrivetrain(){
        return false;
    }
    public void set(){
        
    }
}