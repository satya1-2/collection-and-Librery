package collectionAndLibrery;

import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface IComputeEmployeeWage {
    public void addCompanyEmployeeWage(String company, int employeeRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

    public void computeEmployeeWage();

    public int getTotalWage(String company);
}

class CompanyEmployeeWage {
    public final String company;
    public final int employeeRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmployeeWage;

    public CompanyEmployeeWage(String company, int employeeRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.employeeRatePerHour = employeeRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        totalEmployeeWage = 0;
    }

    public static void setTotalEmployeeWage(int totalEmployeeWage) {
        this.totalEmployeeWage = totalEmployeeWage;
    }

    @Override
    public String toString() {
        return "total employee wage for company : " + company + "is:" + totalEmployeeWage;
    }
}

public class EmployeeWageBuilder implements IComputeEmployeeWage {
    public static final int IsPartTime = 1;
    public static final int IsFullTime = 2;

    private int numOfCompany = 0;
    private LinkedList<CompanyEmployeeWage> companyEmployeeWageList;
    private Map<String, CompanyEmployeeWage> companyToEmployeeWageMap;

    public EmployeeWageBuilder() {
        companyEmployeeWageList = new LinkedList<>();
        companyToEmployeeWageMap = new HashMap<>();
    }

    public void AddCompanyEmployeeWage(String company, int employeeRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmployeeWage companyEmployeeWage = new CompanyEmployeeWage(company, employeeRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmployeeWageList.add(companyEmployeeWage);
        companyToEmployeeWageMap.put(company, companyEmployeeWage);
    }

    public void computeEmployeeWage() {
        for (int i = 0; i <= companyEmployeeWageList.size(); i++) {
            CompanyEmployeeWage companyEmployeeWage = companyEmployeeWageList.get(i);
            CompanyEmployeeWage.setTotalEmployeeWage(this.computeEmployeeWage(companyEmployeeWage));
            System.out.println(companyEmployeeWage);
        }
    }

    @Override
    public int getTotalWage(String company) {
        return companyToEmployeeWageMap.get(company).totalEmployeeWage;
    }

    public int computeEmployeeWage(CompanyEmployeeWage companyEmployeeWage) {...}

    public static void main(String[] args) {
        IComputeEmployeeWage employeeWageBuilder = new EmployeeWageBuilder();
        employeeWageBuilder.addCompanyEmployeeWage("DMart", 20, 2, 10);
        employeeWageBuilder.addCompanyEmployeeWage("reliance", 10, 4, 20);
        employeeWageBuilder.computeEmployeeWage();
        System.out.println("total wage for DMart company:" + employeeWageBuilder.getTotalWage("DMart"));
    }
}
