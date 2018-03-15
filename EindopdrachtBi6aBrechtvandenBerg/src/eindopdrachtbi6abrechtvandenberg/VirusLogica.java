/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindopdrachtbi6abrechtvandenberg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 *
 * @author Brecht
 */
public class VirusLogica {

    
    public ArrayList<Virus> virusList = new ArrayList<>();
    public ArrayList<Virus> hostsublist1 = new ArrayList<>();
    public ArrayList<Virus> hostsublist2 = new ArrayList<>();
    public ArrayList<Virus> overlaplist = new ArrayList<>();
    public HashSet<String> hostidset = new HashSet<>();
    public Integer selectedhost1 = 0;
    public Integer selectedhost2 = 0;
    
    /**
     * making a custom Comparator for the "ID" option within the button group 
     * @return
     */
    public Comparator<Virus> IDComparator() {
        return new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return Integer.compare(o1.getVirus_tax_id(),o2.getHost_tax_id());
            }
            // compare using attribute 1
        };
    }
    
    /**
     * making a custom Comparator for the "Classificatie" option within the button group 
     * @return
     */
    public Comparator<Virus> ClassComparator() {
        return new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                String o1name = o1.getVirus_lineage().split("; ")[1];
                
                return o1name.compareTo(o2.getVirus_lineage().split("; ")[1]);
            }
            // compare using attribute 1
        };
    }

    /**
     * loading an URL or file to use as the input for the program to use
     * @param urlstring
     * @throws IOException
     */
    public void load(String urlstring) throws IOException {

        // Make an URL to the web page
        URL url = new URL(urlstring);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            
            ArrayList<String> split = new ArrayList<String>(Arrays.asList(line.split("\t")));
            
            Integer virus_tax_id = 0;
            Integer host_tax_id = 0;
            
            while (split.size() < 12){
                 split.add("null");
            }
            try{
                virus_tax_id = Integer.parseInt(split.get(0));
                host_tax_id = Integer.parseInt(split.get(7));
            } catch (NumberFormatException ex){
                System.out.println("replaced null with 0");
            }
            
            Virus tempvir = new Virus(virus_tax_id,split.get(1),split.get(2),split.get(3),split.get(4),split.get(5),split.get(6),host_tax_id,split.get(8),split.get(9),split.get(10),split.get(11));
            virusList.add(tempvir);
                        
        
        }
        System.out.println(virusList.size());
        generatehostidlist();
        System.out.println("generated host id list: "+hostidset.size());
        for (String idstring : hostidset){
            System.out.println(idstring);
        }
    }
    
    /**
     * fill the hostidlist with host tax id's
     */
    public void generatehostidlist(){
        
        for (Virus myvirus : virusList){
            String idstring = myvirus.getHost_tax_id()+" ("+myvirus.getHost_name()+")";
            hostidset.add(idstring);
            
        }
    }
    
    /**
     * make a list to use for a dropdown 
     * @param hostid
     */
    public void setsublist1(Integer hostid){
        if (! selectedhost1.equals(hostid)){
            selectedhost1 = hostid;
            hostsublist1.clear();
            for (Virus myvirus : virusList){
                if (myvirus.getHost_tax_id().equals(hostid)){
                    hostsublist1.add(myvirus);
                }
            }
    }
    }
    
    /**
     * make a list to use for a dropdown 
     * @param hostid
     */
    public void setsublist2(Integer hostid){
        if (! selectedhost2.equals(hostid)){
            selectedhost2 = hostid;
            hostsublist2.clear();
            for (Virus myvirus : virusList){
                if (myvirus.getHost_tax_id().equals(hostid)){
                    hostsublist2.add(myvirus);
                }
            }
    }
    }
    
    /**
     * calculates the overlap between the tax id's of both text fields
     */
    public void overlap(){
        overlaplist.clear();
        HashSet<Integer> lookuplist = new HashSet<>();
        for (Virus myvirus : hostsublist2){
            lookuplist.add(myvirus.getVirus_tax_id());
        } 
        for (Virus myvirus : hostsublist1){
            if (lookuplist.contains(myvirus.getVirus_tax_id())){
                overlaplist.add(myvirus);
            }
        }
    }

    /**
     * calling the custom comparator to determine the chosen sorting method
     * @param soortsort
     */
    public void sortsublist1(String soortsort) {    
        if (soortsort.equals("ID")){
        Collections.sort(hostsublist1, this.IDComparator());
        }
        else {
        Collections.sort(hostsublist1, this.ClassComparator());
        }
    }
    
    /**
     * calling the custom comparator to determine the chosen sorting method
     * @param soortsort
     */
    public void sortsublist2(String soortsort) {    
        if (soortsort.equals("ID")){
        Collections.sort(hostsublist2, this.IDComparator());
        }
        else {
        Collections.sort(hostsublist2, this.ClassComparator());
        }
    }
}
