package DZ_06;

public class Laptop {
    // Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    String fabricator;
    String model;
    String color;
    String videoCard;
    int vram;
    int ram;
    int ssd;
    int price;

    public Laptop(String fabricator, String model, String color, String videoCard, int vram, int ram, int ssd, int price){
        this.fabricator = fabricator;
        this.model = model;
        this.color = color;
        this.videoCard = videoCard;
        this.vram = vram;
        this.ram = ram;
        this.ssd = ssd;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return String.format("ноутбук: %s %s, цвет: %s, видеокарта: %s,VRAM %d, RAM: %d, SSD: %d, цена: %d",fabricator, model, color, videoCard, vram, ram, ssd, price);
    }

}
