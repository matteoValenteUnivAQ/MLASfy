package service;

public interface CodaDiRiproduzioneService {
    
    public void importaElemento(Riproducibile elemento);
    
   public void play();
    
   public void pausa();
    
   public void stop();
    
    public void successivo();
    
    public void precedente();
    
    public void setShuffle(boolean shuffle);
    
    public void toggleShuffle();
    
    public void setRepeat(boolean repeat);
    
    public void toggleRepeat();
}