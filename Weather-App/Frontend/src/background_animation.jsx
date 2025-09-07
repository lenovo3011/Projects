
import animation1 from './Cloudy Day.json'
import Lottie from 'lottie-react';
import  './animation_clould.css'
import night from './white-moon.json'
import bydefault from './Beautiful city.json'


export function bg_animation(daystatus) {

    if (daystatus === 1) {
  return (
   <>
   
   <Lottie animationData={animation1} loop = {true} className='an' style={{backgroundColor: 'skyblue'}}>  </Lottie>
 
   
   </>
  )
}




    if (daystatus === 0) { 

    return (
        <>
            <Lottie animationData={night} loop = {true} className='an' style={{backgroundColor : 'black'}}>  </Lottie>
        </>
    )

}

   

    return (
        
<>
        <Lottie animationData={bydefault} loop = {true} className='an'style={{backgroundColor : 'skyblue'}}>  </Lottie>

</>
        
    )




}

