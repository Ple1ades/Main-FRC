package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.RobotController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
public class DrivetrainSubsystem extends SubsystemBase{
    public WPI_VictorSPX m_leftFront = new WPI_VictorSPX(Constants.Drivetrain.leftFront);
    public WPI_TalonFX m_leftBack = new WPI_TalonFX(Constants.Drivetrain.leftBack);
    public SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftFront, m_leftBack);

    public WPI_VictorSPX m_rightFront = new WPI_VictorSPX(Constants.Drivetrain.rightFront);
    public WPI_TalonFX m_rightBack = new WPI_TalonFX(Constants.Drivetrain.rightBack);
    public SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightFront, m_rightBack);

    public DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    
    private PIDController m_leftPIDController;
    private PIDController m_rightPIDController;
    private edu.wpi.first.wpilibj.Encoder m_leftEncoder;
    private edu.wpi.first.wpilibj.Encoder m_rightEncoder;
    
    public void DrivetrainSubsystem(double speed, double rotation){
        //clamp to between -1.0 and 1.0 for speed and rotation to prevent errors
      m_drive.arcadeDrive(speed, rotation);
      // m_leftEncoder = new edu.wpi.first.wpilibj.Encoder(0,1);
      // m_rightEncoder = new edu.wpi.first.wpilibj.Encoder(2,3);

      // m_leftPIDController = new PIDController(Constants.Drivetrain.kP, Constants.Drivetrain.kI, Constants.Drivetrain.kD);
      // m_rightPIDController = new PIDController(Constants.Drivetrain.kP, Constants.Drivetrain.kI, Constants.Drivetrain.kD);
      
      // m_leftEncoder.setDistancePerPulse(2 * Math.PI * Constants.Drivetrain.kWheelRadius / Constants.Drivetrain.kEncoderResolution);
      // m_rightEncoder.setDistancePerPulse(2 * Math.PI * Constants.Drivetrain.kWheelRadius / Constants.Drivetrain.kEncoderResolution);
    }
    
}