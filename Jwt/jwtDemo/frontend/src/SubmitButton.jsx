
import {useFormStatus} from "react-dom"

export const SubmitButton = () => {
    const {pending} = useFormStatus()
  return (
    <button disabled={pending} >
        {pending ? "Submitting Securely..." : "Submit"}
    </button>
   
  );
};
export default SubmitButton;
