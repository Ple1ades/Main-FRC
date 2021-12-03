package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.subsystems.Pneumatic;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


// minimum air pressure = 0
// maxmm air pressure = 0
public class PneumaticMoveReverse extends CommandBase{
    
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Pneumatic m_piston;
    public PneumaticMoveReverse(Pneumatic piston){
        m_piston = piston;
        addRequirements(piston);
    }
    
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_piston.move(Value.kReverse);
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }


}
