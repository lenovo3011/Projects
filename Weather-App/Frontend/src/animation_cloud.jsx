
import animation1 from './Cloudy Day.json'
import Lottie from 'lottie-react';
import  './animation_clould.css'
import night from './white-moon.json'

export function AnimationCloud() {
  return (
   <>
   
   <Lottie animationData={animation1} loop = {true} className='an' style={{backgroundColor: 'skyblue'}}>  </Lottie>
 
   
   </>
  )
}
export function AnimationNight () {
    return (
        <>
            <Lottie animationData={night} loop = {true} className='an' style={{backgroundColor : 'black'}}>  </Lottie>
        </>
    )
}

