package pl.edu.pw.mini.zpoif.task5;

import java.util.List;

import pl.edu.pw.mini.zpoif.task5.solution.AllowedValues;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.AddMulti;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.InitiateObject;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.MethodInvoker;

@InitiateObject(ilosc=2)
public class Autobus {
	
	protected String model = "WSK-125";
	
	@AddMulti(value = Kierowca.class)
	protected List<Kierowca> kierowcy;
	
	@AddMulti(value = Pasazer.class)
	protected List<Pasazer> pasazerowie;
	
	protected Silnik silnik;
	
	@AddMulti(value = Bagaz.class)
	protected List<Bagaz> bagaze;

	@Override
	@MethodInvoker(licznikWywolan = AllowedValues.ONE)
	public String toString() {
		return "Autobus [model=" + model + "]";
	}
	
	@MethodInvoker(licznikWywolan = AllowedValues.ONE)
	public void sayHello() {
		System.out.println("Hello!");
	}
	
	
	
}
