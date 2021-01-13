package Movies;
//import 	Enum.GenerMovieEnum;

import Enum.ProductionJobEnum;


public class Production {//����� ������
    private String ActorName;
    private String DirectorName;
    private ProductionJobEnum job;

    public Production(ProductionJobEnum job, String ActorName, String DirectorName) {//����� 
        this.job = job;
        this.ActorName = ActorName;
        this.DirectorName = DirectorName;
    }

    public int getSalaryfromjob()    //������� ����� 
    {
        int Salary = 0;
        switch (job) {
            case Actor:
                Salary = (int) (Math.random() * 10000000);
                break;
            case Director:
                Salary = (int) (Math.random() * 100000);
                break;
        }
        return Salary;
    }

    @Override
    public String toString() { // �����
        String str = "";
        str = "Actor Name: " + ActorName + " ,Director Name: " + DirectorName + ".\n" + job.name() + " got paid "
                + getSalaryfromjob() + "$.\n";
        return str;
    }

}

