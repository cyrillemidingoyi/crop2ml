import  java.io.*;
import  java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.util.*;
import java.time.LocalDateTime;
public class Energybalance
{
    private double albedoCoefficient;
    public double getalbedoCoefficient()
    { return albedoCoefficient; }

    public void setalbedoCoefficient(double _albedoCoefficient)
    { this.albedoCoefficient= _albedoCoefficient; } 
    
    private double stefanBoltzman;
    public double getstefanBoltzman()
    { return stefanBoltzman; }

    public void setstefanBoltzman(double _stefanBoltzman)
    { this.stefanBoltzman= _stefanBoltzman; } 
    
    private double elevation;
    public double getelevation()
    { return elevation; }

    public void setelevation(double _elevation)
    { this.elevation= _elevation; } 
    
    private double lambdaV;
    public double getlambdaV()
    { return lambdaV; }

    public void setlambdaV(double _lambdaV)
    { this.lambdaV= _lambdaV; } 
    
    private double psychrometricConstant;
    public double getpsychrometricConstant()
    { return psychrometricConstant; }

    public void setpsychrometricConstant(double _psychrometricConstant)
    { this.psychrometricConstant= _psychrometricConstant; } 
    
    private double Alpha;
    public double getAlpha()
    { return Alpha; }

    public void setAlpha(double _Alpha)
    { this.Alpha= _Alpha; } 
    
    private double vonKarman;
    public double getvonKarman()
    { return vonKarman; }

    public void setvonKarman(double _vonKarman)
    { this.vonKarman= _vonKarman; } 
    
    private double heightWeatherMeasurements;
    public double getheightWeatherMeasurements()
    { return heightWeatherMeasurements; }

    public void setheightWeatherMeasurements(double _heightWeatherMeasurements)
    { this.heightWeatherMeasurements= _heightWeatherMeasurements; } 
    
    private double zm;
    public double getzm()
    { return zm; }

    public void setzm(double _zm)
    { this.zm= _zm; } 
    
    private double d;
    public double getd()
    { return d; }

    public void setd(double _d)
    { this.d= _d; } 
    
    private double zh;
    public double getzh()
    { return zh; }

    public void setzh(double _zh)
    { this.zh= _zh; } 
    
    private double soilDiffusionConstant;
    public double getsoilDiffusionConstant()
    { return soilDiffusionConstant; }

    public void setsoilDiffusionConstant(double _soilDiffusionConstant)
    { this.soilDiffusionConstant= _soilDiffusionConstant; } 
    
    private double rhoDensityAir;
    public double getrhoDensityAir()
    { return rhoDensityAir; }

    public void setrhoDensityAir(double _rhoDensityAir)
    { this.rhoDensityAir= _rhoDensityAir; } 
    
    private double specificHeatCapacityAir;
    public double getspecificHeatCapacityAir()
    { return specificHeatCapacityAir; }

    public void setspecificHeatCapacityAir(double _specificHeatCapacityAir)
    { this.specificHeatCapacityAir= _specificHeatCapacityAir; } 
    
    private double tau;
    public double gettau()
    { return tau; }

    public void settau(double _tau)
    { this.tau= _tau; } 
    
    private double tauAlpha;
    public double gettauAlpha()
    { return tauAlpha; }

    public void settauAlpha(double _tauAlpha)
    { this.tauAlpha= _tauAlpha; } 
    
    private int isWindVpDefined;
    public int getisWindVpDefined()
    { return isWindVpDefined; }

    public void setisWindVpDefined(int _isWindVpDefined)
    { this.isWindVpDefined= _isWindVpDefined; } 
    
    public Energybalance() { }
    public void  Calculate_energybalance(EnergybalanceState s, EnergybalanceState s1, EnergybalanceRate r, EnergybalanceAuxiliary a)
    {
        //- Name: EnergyBalance -Version: 001, -Time step: 1
        //- Description:
    //            * Title: EnergyBalance
    //            * Author: Pierre MARTRE
    //            * Reference: Modelling energy balance in the wheat crop model SiriusQuality2: Evapotranspiration and canopy and soil temperature calculations
    //            * Institution: INRA/LEPSE
    //            * Abstract: see documentation at http://www1.clermont.inra.fr/siriusquality/?page_id=547
        //- inputs:
    //            * name: minTair
    //                          ** description : minimum air temperature
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : -30
    //                          ** max : 45
    //                          ** default : 0.7
    //                          ** unit : ??C
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: maxTair
    //                          ** description : maximum air Temperature
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : -30
    //                          ** max : 45
    //                          ** default : 7.2
    //                          ** unit : ??C
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: albedoCoefficient
    //                          ** description : albedo Coefficient
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.23
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: stefanBoltzman
    //                          ** description : stefan Boltzman constant
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 4.903E-09
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: elevation
    //                          ** description : elevation
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0
    //                          ** min : -500
    //                          ** max : 10000
    //                          ** unit : m
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: solarRadiation
    //                          ** description : solar Radiation
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 3
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : MJ m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: vaporPressure
    //                          ** description : vapor Pressure
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 6.1
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : hPa
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: extraSolarRadiation
    //                          ** description : extra Solar Radiation
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 11.7
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : MJ m2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: lambdaV
    //                          ** description : latent heat of vaporization of water
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 2.454
    //                          ** min : 0
    //                          ** max : 10
    //                          ** unit : MJ kg-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: hslope
    //                          ** description : the slope of saturated vapor pressure temperature curve at a given temperature 
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 0.584
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : hPa ??C-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: psychrometricConstant
    //                          ** description : psychrometric constant
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.66
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: Alpha
    //                          ** description : Priestley-Taylor evapotranspiration proportionality constant
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 1.5
    //                          ** min : 0
    //                          ** max : 100
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: vonKarman
    //                          ** description : von Karman constant
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 1
    //                          ** default : 0.42
    //                          ** unit : dimensionless
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //                          ** parametercategory : constant
    //            * name: heightWeatherMeasurements
    //                          ** description : reference height of wind and humidity measurements
    //                          ** parametercategory : soil
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10
    //                          ** default : 2
    //                          ** unit : m
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: zm
    //                          ** description : roughness length governing momentum transfer, FAO
    //                          ** parametercategory : constant
    //                          ** inputtype : parameter
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 1
    //                          ** default : 0.13
    //                          ** unit : m
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: d
    //                          ** description : corresponding to 2/3. This is multiplied to the crop heigth for calculating the zero plane displacement height, FAO
    //                          ** inputtype : parameter
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.67
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : dimensionless
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547rl
    //            * name: zh
    //                          ** description : roughness length governing transfer of heat and vapour, FAO
    //                          ** parametercategory : constant
    //                          ** inputtype : parameter
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 1
    //                          ** default : 0.013
    //                          ** unit : m
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: plantHeight
    //                          ** description : plant Height
    //                          ** datatype : DOUBLE
    //                          ** default : 0
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : mm
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //                          ** variablecategory : auxiliary
    //            * name: wind
    //                          ** description : wind
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 124000
    //                          ** min : 0
    //                          ** max : 1000000
    //                          ** unit : m/d
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: deficitOnTopLayers
    //                          ** description : deficit On TopLayers
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 5341
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: soilDiffusionConstant
    //                          ** description : soil Diffusion Constant
    //                          ** parametercategory : soil
    //                          ** datatype : DOUBLE
    //                          ** default : 4.2
    //                          ** min : 0
    //                          ** max : 10
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: VPDair
    //                          ** description :  vapour pressure density
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 2.19
    //                          ** min : 0
    //                          ** max : 1000
    //                          ** unit : hPa
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : variable
    //            * name: rhoDensityAir
    //                          ** description : Density of air
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 1.225
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: specificHeatCapacityAir
    //                          ** description : Specific heat capacity of dry air
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.00101
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: tau
    //                          ** description : plant cover factor
    //                          ** parametercategory : species
    //                          ** datatype : DOUBLE
    //                          ** default : 0.9983
    //                          ** min : 0
    //                          ** max : 100
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: tauAlpha
    //                          ** description : Fraction of the total net radiation exchanged at the soil surface when AlpaE = 1
    //                          ** parametercategory : soil
    //                          ** datatype : DOUBLE
    //                          ** default : 0.3
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
    //            * name: isWindVpDefined
    //                          ** description : if wind and vapour pressure are defined
    //                          ** parametercategory : constant
    //                          ** datatype : INT
    //                          ** default : 1
    //                          ** min : 0
    //                          ** max : 1
    //                          ** unit : 
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //                          ** inputtype : parameter
        //- outputs:
    //            * name: netRadiation
    //                          ** description :  net radiation 
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : MJ m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: netOutGoingLongWaveRadiation
    //                          ** description : net OutGoing Long Wave Radiation 
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: netRadiationEquivalentEvaporation
    //                          ** variablecategory : auxiliary
    //                          ** description : net Radiation in Equivalent Evaporation 
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: evapoTranspirationPriestlyTaylor
    //                          ** description : evapoTranspiration of Priestly Taylor 
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: diffusionLimitedEvaporation
    //                          ** description : the evaporation from the diffusion limited soil 
    //                          ** variablecategory : state
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: energyLimitedEvaporation
    //                          ** description : energy Limited Evaporation 
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: conductance
    //                          ** description : the boundary layer conductance
    //                          ** variablecategory : state
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : m/d
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: evapoTranspirationPenman
    //                          ** description :  evapoTranspiration of Penman Monteith
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: soilEvaporation
    //                          ** description : soil Evaporation
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 5000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: evapoTranspiration
    //                          ** description : evapoTranspiration
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : mm
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: potentialTranspiration
    //                          ** description : potential Transpiration 
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: soilHeatFlux
    //                          ** description : soil Heat Flux 
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: cropHeatFlux
    //                          ** description :  crop Heat Flux
    //                          ** variablecategory : rate
    //                          ** datatype : DOUBLE
    //                          ** min : 0
    //                          ** max : 10000
    //                          ** unit : g m-2 d-1
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: minCanopyTemperature
    //                          ** description : minimal Canopy Temperature  
    //                          ** datatype : DOUBLE
    //                          ** variablecategory : state
    //                          ** min : -30
    //                          ** max : 45
    //                          ** unit : degC
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
    //            * name: maxCanopyTemperature
    //                          ** description : maximal Canopy Temperature 
    //                          ** datatype : DOUBLE
    //                          ** variablecategory : state
    //                          ** min : -30
    //                          ** max : 45
    //                          ** unit : degC
    //                          ** uri : http://www1.clermont.inra.fr/siriusquality/?page_id=547
        double minTair = a.getminTair();
        double maxTair = a.getmaxTair();
        double solarRadiation = a.getsolarRadiation();
        double vaporPressure = a.getvaporPressure();
        double extraSolarRadiation = a.getextraSolarRadiation();
        double hslope = a.gethslope();
        double plantHeight = a.getplantHeight();
        double wind = a.getwind();
        double deficitOnTopLayers = a.getdeficitOnTopLayers();
        double VPDair = a.getVPDair();
        double netRadiation;
        double netOutGoingLongWaveRadiation;
        double netRadiationEquivalentEvaporation;
        double evapoTranspirationPriestlyTaylor;
        double conductance;
        double diffusionLimitedEvaporation;
        double evapoTranspirationPenman;
        double energyLimitedEvaporation;
        double soilEvaporation;
        double evapoTranspiration;
        double soilHeatFlux;
        double potentialTranspiration;
        double cropHeatFlux;
        double minCanopyTemperature;
        double maxCanopyTemperature;
        _Diffusionlimitedevaporation.Calculate_diffusionlimitedevaporation(s, s1, r, a);
        _Conductance.Calculate_conductance(s, s1, r, a);
        _Netradiation.Calculate_netradiation(s, s1, r, a);
        _Netradiationequivalentevaporation.Calculate_netradiationequivalentevaporation(s, s1, r, a);
        _Priestlytaylor.Calculate_priestlytaylor(s, s1, r, a);
        _Penman.Calculate_penman(s, s1, r, a);
        _Evapotranspiration.Calculate_evapotranspiration(s, s1, r, a);
        _Potentialtranspiration.Calculate_potentialtranspiration(s, s1, r, a);
        _Ptsoil.Calculate_ptsoil(s, s1, r, a);
        _Soilevaporation.Calculate_soilevaporation(s, s1, r, a);
        _Soilheatflux.Calculate_soilheatflux(s, s1, r, a);
        _Cropheatflux.Calculate_cropheatflux(s, s1, r, a);
        _Canopytemperature.Calculate_canopytemperature(s, s1, r, a);
        a.setnetRadiation(netRadiation);
        a.setnetOutGoingLongWaveRadiation(netOutGoingLongWaveRadiation);
        a.setnetRadiationEquivalentEvaporation(netRadiationEquivalentEvaporation);
        r.setevapoTranspirationPriestlyTaylor(evapoTranspirationPriestlyTaylor);
        s.setconductance(conductance);
        s.setdiffusionLimitedEvaporation(diffusionLimitedEvaporation);
        r.setevapoTranspirationPenman(evapoTranspirationPenman);
        a.setenergyLimitedEvaporation(energyLimitedEvaporation);
        a.setsoilEvaporation(soilEvaporation);
        r.setevapoTranspiration(evapoTranspiration);
        r.setsoilHeatFlux(soilHeatFlux);
        r.setpotentialTranspiration(potentialTranspiration);
        r.setcropHeatFlux(cropHeatFlux);
        s.setminCanopyTemperature(minCanopyTemperature);
        s.setmaxCanopyTemperature(maxCanopyTemperature);
    }
}