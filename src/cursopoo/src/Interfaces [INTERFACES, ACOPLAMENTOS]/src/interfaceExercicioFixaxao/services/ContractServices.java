package src.interfaceExercicioFixaxao.services;

import src.interfaceExercicioFixaxao.entities.Contract;
import src.interfaceExercicioFixaxao.entities.Installment;

import java.time.LocalDate;

public class ContractServices {

    private final PaymentService paymentService;

    public ContractServices(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int month){
        LocalDate proximaData = LocalDate.from(contract.getContractDate());
        for (int i = 1;i <= month;i++){
            proximaData = proximaData.plusMonths(1);
            double contractValue = paymentService.paymentFee(paymentService.interest(contract.getContractValue()/month, i));
            contract.addInstallment(new Installment(proximaData, contractValue));
        }
    }

}
