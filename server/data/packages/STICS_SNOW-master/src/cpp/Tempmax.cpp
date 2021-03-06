#define _USE_MATH_DEFINES
#include <cmath>
#include <iostream>
# include<vector>
# include<string>
# include<numeric>
# include<algorithm>
# include<array>
#include <map>
# include <tuple>
#include "Tempmax.h"
using namespace std;

Tempmax::Tempmax() { }
float Tempmax::getP_prof() {return this-> P_prof; }
float Tempmax::getP_tminseuil() {return this-> P_tminseuil; }
float Tempmax::getP_tmaxseuil() {return this-> P_tmaxseuil; }
void Tempmax::setP_prof(float _P_prof) { this->P_prof = _P_prof; }
void Tempmax::setP_tminseuil(float _P_tminseuil) { this->P_tminseuil = _P_tminseuil; }
void Tempmax::setP_tmaxseuil(float _P_tmaxseuil) { this->P_tmaxseuil = _P_tmaxseuil; }
void Tempmax::Calculate_Model(SnowState& s, SnowState& s1, SnowRate& r, SnowAuxiliary& a)
{
    //- Name: TempMax -Version: 1.0, -Time step: 1
    //- Description:
    //            * Title: Maximum temperature  recalculation
    //            * Author: STICS
    //            * Reference: -
    //            * Institution: INRA
    //            * Abstract: -
    //- inputs:
    //            * name: Sdepth_cm
    //                          ** description : snow depth
    //                          ** inputtype : variable
    //                          ** variablecategory : state
    //                          ** datatype : DOUBLE
    //                          ** default : 0.0
    //                          ** min : 0.0
    //                          ** max : 500.0
    //                          ** unit : cm
    //                          ** uri : 
    //            * name: P_prof
    //                          ** description : snow cover threshold for snow insulation 
    //                          ** inputtype : parameter
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.0
    //                          ** min : 0.0
    //                          ** max : 1000
    //                          ** unit : cm
    //                          ** uri : 
    //            * name: tmax
    //                          ** description : current maximum air temperature
    //                          ** inputtype : variable
    //                          ** variablecategory : auxiliary
    //                          ** datatype : DOUBLE
    //                          ** default : 0.0
    //                          ** min : 0.0
    //                          ** max : 100.0
    //                          ** unit : ??C
    //                          ** uri : 
    //            * name: P_tminseuil
    //                          ** description : minimum temperature when snow cover is higher than prof
    //                          ** inputtype : parameter
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.0
    //                          ** min : 0.0
    //                          ** max : 5000.0
    //                          ** unit : ??C
    //                          ** uri : 
    //            * name: P_tmaxseuil
    //                          ** description : maximum temperature when snow cover is higher than prof
    //                          ** inputtype : parameter
    //                          ** parametercategory : constant
    //                          ** datatype : DOUBLE
    //                          ** default : 0.0
    //                          ** min : 
    //                          ** max : 
    //                          ** unit : ??C
    //                          ** uri : 
    //- outputs:
    //            * name: tmaxrec
    //                          ** description : recalculated maximum temperature
    //                          ** variablecategory : state
    //                          ** datatype : DOUBLE
    //                          ** min : 0.0
    //                          ** max : 500.0
    //                          ** unit : ??C
    //                          ** uri : 
    float Sdepth_cm = s.getSdepth_cm();
    float tmax = a.gettmax();
    float tmaxrec;
    tmaxrec = tmax;
    if (Sdepth_cm > P_prof)
    {
        if (tmax < P_tminseuil)
        {
            tmaxrec = P_tminseuil;
        }
        else
        {
            if (tmax > P_tmaxseuil)
            {
                tmaxrec = P_tmaxseuil;
            }
        }
    }
    else
    {
        if (Sdepth_cm > 0.0f)
        {
            if (tmax <= 0.0f)
            {
                tmaxrec = P_tmaxseuil - ((1 - (Sdepth_cm / P_prof)) * -tmax);
            }
            else
            {
                tmaxrec = 0.0f;
            }
        }
    }
    s.settmaxrec(tmaxrec);
}