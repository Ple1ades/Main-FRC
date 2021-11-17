package frc.robot.commands;

// import java.util.Timer;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;


public class InverseVisionAlign extends CommandBase{
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DrivetrainSubsystem m_drive;
    public InverseVisionAlign(DrivetrainSubsystem drive){
        m_drive = drive;
        addRequirements(drive);
    }
    
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_drive.inverseVisionAlign();
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
