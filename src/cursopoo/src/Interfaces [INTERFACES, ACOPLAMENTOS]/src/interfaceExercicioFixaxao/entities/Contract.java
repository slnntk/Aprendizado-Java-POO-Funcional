package src.interfaceExercicioFixaxao.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {


    private Contract contract;
    private final LocalDateTime contractDate;
    private final Integer contractNumber;
    private final Double contractValue;
    private final List<Installment> installmentList = new ArrayList<>();

    public Contract(LocalDateTime contractDate, Integer contractNumber, Double contractValue) {
        this.contractDate = contractDate;
        this.contractNumber = contractNumber;
        this.contractValue = contractValue;
    }

    public void processInvoice(int meses){
        LocalDateTime proximaData = getContractDate();
        for (int i = 0;i < meses;i++){
            proximaData = proximaData.plusDays(31);
            installmentList.add(new Installment(proximaData, contractValue/meses));
        }

    }

    public void portionContract(){
        System.out.println("Parcelas");
        for (Installment installment : contract.getContract().getInstallmentList()){
            System.out.printf("%s - %.2f%n", installment.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), installment.getAmmout());
        }
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public LocalDateTime getContractDate() {
        return contractDate;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public Double getContractValue() {
        return contractValue;
    }
}
