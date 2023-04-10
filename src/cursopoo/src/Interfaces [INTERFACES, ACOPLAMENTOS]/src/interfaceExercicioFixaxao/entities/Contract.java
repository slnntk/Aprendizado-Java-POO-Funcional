package src.interfaceExercicioFixaxao.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private final LocalDate contractDate;
    private final Integer contractNumber;
    private final Double contractValue;
    private final List<Installment> installmentList = new ArrayList<>();


    public Contract(LocalDate contractDate, Integer contractNumber, Double contractValue) {
        this.contractDate = contractDate;
        this.contractNumber = contractNumber;
        this.contractValue = contractValue;
    }

    public void addInstallment(Installment parcela){
        installmentList.add(parcela);
    }

    public void getAllInstallment(){
        System.out.println();
        System.out.println("Parcelas");
        for (Installment installment : getInstallmentList()){
            System.out.println(installment.toString());
        }
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }
}
