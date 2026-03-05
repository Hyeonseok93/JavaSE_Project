
package chap07;

public class TV extends Appliance {

    public TV( String modelNo ){
        super( modelNo );
    } 
    public void volumeUp() {
        System.out.println( "TV 볼룸업" );
    }

    public void volumeDown() {
        System.out.println( "TV 볼룸다운" );
    } 
  
}
