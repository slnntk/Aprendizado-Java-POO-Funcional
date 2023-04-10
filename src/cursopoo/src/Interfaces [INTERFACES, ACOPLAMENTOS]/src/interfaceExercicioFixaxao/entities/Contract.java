package src.interfaceExercicioFixaxao.entities;

import src.interfaceExercicioFixaxao.services.PayPalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {


    private Contract contract;
    private LocalDateTime contractDate;
    private Integer contractNumber;
    private Double contractValue;
    private List<Invoice> invoiceList = new ArrayList<>();

    public Contract(LocalDateTime contractDate, Integer contractNumber, Double contractValue) {
        this.contractDate = contractDate;
        this.contractNumber = contractNumber;
        this.contractValue = contractValue;
    }

    public void invoiceListCreation(int meses){

        LocalDateTime proximaData = getContractDate();
        for (int i = 0;i < meses;i++){
            proximaData = proximaData.plusDays(31);
           invoiceList.add(new Invoice((getContractValue() / meses),new PayPalService(getContractValue()/meses, i+1) ,proximaData,getContract()));
        }

    }

    public void portionContract(){
        System.out.println("Parcelas");
        for (Invoice invoice : contract.getContract().getInvoiceList()){
            System.out.printf("%s - %.2f%n", invoice.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), invoice.getTax().getTax());
        }
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
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

    public void setContractDate(LocalDateTime contractDate) {
        this.contractDate = contractDate;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }
}
