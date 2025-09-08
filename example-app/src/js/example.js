import { RingtonePicker } from 'ringtone-picker';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    RingtonePicker.echo({ value: inputValue })
}
