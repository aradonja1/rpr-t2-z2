package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pocetnaTackaPripada, krajnjaTackaPripada;


    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaTackaPripada, boolean krajnjaTackaPripada)  {
        if( pocetnaTacka > krajnjaTacka ) throw new IllegalArgumentException("Pocetna tacka je veca od krajnje tacke!");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaTackaPripada = pocetnaTackaPripada;
        this.krajnjaTackaPripada = krajnjaTackaPripada;
    }

    public Interval() {
        this(0, 0, false, false);
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPocetnaTackaPripada() {
        return pocetnaTackaPripada;
    }

    public void setPocetnaTackaPripada(boolean pocetnaTackaPripada) {
        this.pocetnaTackaPripada = pocetnaTackaPripada;
    }

    public boolean isKrajnjaTackaPripada() {
        return krajnjaTackaPripada;
    }

    public void setKrajnjaTackaPripada(boolean krajnjaTackaPripada) {
        this.krajnjaTackaPripada = krajnjaTackaPripada;
    }


    public boolean isNull() {
        if(this.getKrajnjaTacka() == 0 && this.getPocetnaTacka() == 0) return true;
        return  false;
    }


    public boolean isIn(double v) {
        if( this.getPocetnaTacka() <= v && this.getKrajnjaTacka() > v ) return true;
        return false;
    }

    public Interval intersect(Interval interval) {
        double pocetakIntervala, krajIntervala;
        Interval i = new Interval();
        if( this.getPocetnaTacka() < interval.getPocetnaTacka() ) {
            pocetakIntervala = interval.getPocetnaTacka();
            i.setPocetnaTackaPripada( interval.isPocetnaTackaPripada() );
        }
        else {
            pocetakIntervala = this.getPocetnaTacka();
            i.setPocetnaTackaPripada( this.isPocetnaTackaPripada() );
        }
        if( this.getKrajnjaTacka() < interval.getKrajnjaTacka() ) {
            krajIntervala = this.getKrajnjaTacka();
            i.setKrajnjaTackaPripada( this.isKrajnjaTackaPripada() );
        }
        else {
            krajIntervala = interval.getKrajnjaTacka();
            i.setKrajnjaTackaPripada( interval.isKrajnjaTackaPripada() );
        }
        i.setPocetnaTacka(pocetakIntervala);
        i.setKrajnjaTacka(krajIntervala);
         return i;
    }


    public static Interval intersect(Interval interval1, Interval interval2) {
        Interval i = interval1.intersect(interval2);
        return  i;
    }

    @Override
    public String toString() {
        String s = "";
        if(this.isNull()) return "()";
        if( this.isPocetnaTackaPripada() ) s = "[";
        else s = "(";
        s = s + this.getPocetnaTacka() + "," + this.getKrajnjaTacka();
        if( this.isKrajnjaTackaPripada() ) s = s + "]";
        else s = s + ")";
        return  s;
    }
}
