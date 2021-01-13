package Movies;
//import 	Enum.GenerMovieEnum;

import Enum.ProductionJobEnum;


public class Production {//הגדרת משתנים
    private String ActorName;
    private String DirectorName;
    private ProductionJobEnum job;

    public Production(ProductionJobEnum job, String ActorName, String DirectorName) {//בנאים 
        this.job = job;
        this.ActorName = ActorName;
        this.DirectorName = DirectorName;
    }

    public int getSalaryfromjob()    //משכורות הגדרת 
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
    public String toString() { // הדפסה
        String str = "";
        str = "Actor Name: " + ActorName + " ,Director Name: " + DirectorName + ".\n" + job.name() + " got paid "
                + getSalaryfromjob() + "$.\n";
        return str;
    }

}

