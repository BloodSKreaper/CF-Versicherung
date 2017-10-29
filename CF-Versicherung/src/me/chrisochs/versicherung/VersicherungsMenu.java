package me.chrisochs.versicherung;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import utils.Utils;
import versicherungen.Versicherungen;

public class VersicherungsMenu{

	private static Inventory inv;
	public VersicherungsMenu(Plugin plugin){
		this.createInventory();
	}
	
	public static Inventory getInventory(Player p){
		Inventory invent = inv;
		invent.setItem(8,getPlayerHead(p));
		return invent;
	}
	
	private static ItemStack getPlayerHead(Player p){
		ItemStack istack= new ItemStack(Material.SKULL_ITEM,1,(short)3);
		List<String> lore = new ArrayList<String>();
		lore.add("§aDeine aktuelle Versicherung:");
		lore.add(Utils.getPlayerVersicherung(p.getUniqueId()).getName());
		lore.add("§aLäuft aus am:");
		lore.add(Utils.getPlayerVersicherung(p.getUniqueId()).getRuntimeEndAsString());
		SkullMeta meta = (SkullMeta)istack.getItemMeta();
		meta.setOwningPlayer(p);
		meta.setDisplayName("§2Steve's Versicherung");
		meta.setLore(lore);
		istack.setItemMeta(meta);
		return istack;
		
	}
	
	public void createInventory(){
		inv = Bukkit.getServer().createInventory(null, 45, "§6§l§oC§7§oF §aVersicherung");
		
		//Versicherung I
		ItemStack istack1= new ItemStack(Material.PAPER,1);
		this.setMeta(istack1, Versicherungen.ONE.getVersicherung().getName(), Versicherungen.ONE.getVersicherung().getDescription());
		
		ItemStack istack2= new ItemStack(Material.INK_SACK,1,(short)4);
		this.setMeta(istack2, "§2§lEine Woche", getLoreDauer(1, Versicherungen.ONE.getVersicherung().getPrice(), Versicherungen.ONE.getVersicherung().getName()));
		
		ItemStack istack3= new ItemStack(Material.DIAMOND,1);
		setMeta(istack3, "§2§lZwei Wochen", getLoreDauer(2, Versicherungen.ONE.getVersicherung().getPrice(), Versicherungen.ONE.getVersicherung().getName()));
		
		ItemStack istack4= new ItemStack(Material.EMERALD,1);
		setMeta(istack4, "§2§lDrei Wochen", getLoreDauer(3, Versicherungen.ONE.getVersicherung().getPrice(), Versicherungen.ONE.getVersicherung().getName()));

		//Versicherung II
		ItemStack istack5= new ItemStack(Material.PAPER,1);
		this.setMeta(istack1, Versicherungen.TWO.getVersicherung().getName(), Versicherungen.TWO.getVersicherung().getDescription());
		
		ItemStack istack6= new ItemStack(Material.INK_SACK,1,(short)4);
		this.setMeta(istack2, "§2§lEine Woche", getLoreDauer(1, Versicherungen.TWO.getVersicherung().getPrice(), Versicherungen.TWO.getVersicherung().getName()));
		
		ItemStack istack7= new ItemStack(Material.DIAMOND,1);
		setMeta(istack3, "§2§lZwei Wochen", getLoreDauer(2, Versicherungen.TWO.getVersicherung().getPrice(), Versicherungen.TWO.getVersicherung().getName()));
		
		ItemStack istack8= new ItemStack(Material.EMERALD,1);
		setMeta(istack4, "§2§lDrei Wochen", getLoreDauer(3, Versicherungen.TWO.getVersicherung().getPrice(), Versicherungen.TWO.getVersicherung().getName()));
		
		//Versicherung III
		ItemStack istack9= new ItemStack(Material.PAPER,1);
		this.setMeta(istack1, Versicherungen.THREE.getVersicherung().getName(), Versicherungen.THREE.getVersicherung().getDescription());
		
		ItemStack istack10= new ItemStack(Material.INK_SACK,1,(short)4);
		this.setMeta(istack2, "§2§lEine Woche", getLoreDauer(1, Versicherungen.THREE.getVersicherung().getPrice(), Versicherungen.THREE.getVersicherung().getName()));
		
		ItemStack istack11= new ItemStack(Material.DIAMOND,1);
		setMeta(istack3, "§2§lZwei Wochen", getLoreDauer(2, Versicherungen.THREE.getVersicherung().getPrice(), Versicherungen.THREE.getVersicherung().getName()));
		
		ItemStack istack12= new ItemStack(Material.EMERALD,1);
		setMeta(istack4, "§2§lDrei Wochen", getLoreDauer(3, Versicherungen.THREE.getVersicherung().getPrice(), Versicherungen.THREE.getVersicherung().getName()));
		
		//Versicherung IV
		ItemStack istack13= new ItemStack(Material.PAPER,1);
		this.setMeta(istack1, Versicherungen.FOUR.getVersicherung().getName(), Versicherungen.FOUR.getVersicherung().getDescription());
		
		ItemStack istack14= new ItemStack(Material.INK_SACK,1,(short)4);
		this.setMeta(istack2, "§2§lEine Woche", getLoreDauer(1, Versicherungen.FOUR.getVersicherung().getPrice(), Versicherungen.FOUR.getVersicherung().getName()));
		
		ItemStack istack15= new ItemStack(Material.DIAMOND,1);
		setMeta(istack3, "§2§lZwei Wochen", getLoreDauer(2, Versicherungen.FOUR.getVersicherung().getPrice(), Versicherungen.FOUR.getVersicherung().getName()));
		
		ItemStack istack16= new ItemStack(Material.EMERALD,1);
		setMeta(istack4, "§2§lDrei Wochen", getLoreDauer(3, Versicherungen.FOUR.getVersicherung().getPrice(), Versicherungen.FOUR.getVersicherung().getName()));
		
		//Versicherung V
		ItemStack istack17= new ItemStack(Material.PAPER,1);
		this.setMeta(istack1, Versicherungen.FIVE.getVersicherung().getName(), Versicherungen.FIVE.getVersicherung().getDescription());
		
		ItemStack istack18= new ItemStack(Material.INK_SACK,1,(short)4);
		this.setMeta(istack2, "§2§lEine Woche", getLoreDauer(1, Versicherungen.FIVE.getVersicherung().getPrice(), Versicherungen.FIVE.getVersicherung().getName()));
		
		ItemStack istack19= new ItemStack(Material.DIAMOND,1);
		setMeta(istack3, "§2§lZwei Wochen", getLoreDauer(2, Versicherungen.FIVE.getVersicherung().getPrice(), Versicherungen.FIVE.getVersicherung().getName()));
		
		ItemStack istack20= new ItemStack(Material.EMERALD,1);
		setMeta(istack4, "§2§lDrei Wochen", getLoreDauer(3, Versicherungen.FIVE.getVersicherung().getPrice(), Versicherungen.FIVE.getVersicherung().getName()));


		
		
		

		
		ItemStack istack22= new ItemStack(Material.BARRIER);
		List<String> lore22 = new ArrayList<String>();
		lore22.add("§aBisherige Versicherung §nohne");
		lore22.add("§aRückerstattung kündigen");
		lore22.add("§eNur deine Rüstung");
		lore22.add("§ewird geschützt!");
		ItemMeta istackMeta22 = istack22.getItemMeta();
		istackMeta22.setLore(lore22);
		istackMeta22.setDisplayName("§6§lKündigen");
		istack22.setItemMeta(istackMeta22);
		
		ItemStack istack23= new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
		ItemMeta istackMeta23 = istack23.getItemMeta();
		istackMeta23.setDisplayName("§4§lSchließen");
		istack23.setItemMeta(istackMeta23);
		
		
		
		
		inv.setItem(1, istack1);
		inv.setItem(19, istack2);
		inv.setItem(28, istack3);
		inv.setItem(37, istack4);
		
		inv.setItem(2, istack5);
		inv.setItem(20, istack6);
		inv.setItem(29, istack7);
		inv.setItem(38, istack8);
		
		inv.setItem(3, istack9);
		inv.setItem(21, istack10);
		inv.setItem(30, istack11);
		inv.setItem(39, istack12);
		
		inv.setItem(4, istack13);
		inv.setItem(22, istack14);
		inv.setItem(31, istack15);
		inv.setItem(40, istack16);
		
		inv.setItem(5, istack17);
		inv.setItem(23, istack18);
		inv.setItem(32, istack19);
		inv.setItem(41, istack20);
		
		inv.setItem(26, istack22);
		inv.setItem(44, istack23);
	}
	
	public void setMeta(ItemStack itemstack, String displayname,List<String> lore){
		ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setDisplayName("§6§l"+displayname);
		itemmeta.setLore(lore);
		itemstack.setItemMeta(itemmeta);
	}

	public List<String> getLoreDauer(int faktor, double price, String name){
		List<String> lore = new ArrayList<String>();
		lore.add("§6§lPreis:§r                  §4"+price*faktor+"\u00A2");
		lore.add("§6§lVersicherung:§r      §4"+name);
		lore.add("");
		lore.add("§aKlicken zum Kaufen");
		lore.add("§4Bisherige Versicherung wird");
		lore.add("§4ohne Rückerstattung gekündigt!");
		return lore;
	}
	
}
