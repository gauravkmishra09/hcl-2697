import React from "react";
import { useFormStatus } from "react-dom";

const SubmitButton = () => {
    const { pending } = useFormStatus();

    return (
        <button
            type="submit"
            disabled={pending}
            className={`w-full inline-flex items-center justify-center gap-2 px-6 py-3.5 rounded-xl font-semibold text-white tracking-wide shadow-md transition-all duration-200 ${
                pending
                    ? "bg-slate-500 cursor-not-allowed opacity-80"
                    : "bg-slate-900 hover:bg-slate-800 active:scale-98 cursor-pointer shadow-slate-900/15"
            }`}
        >
            {pending ? (
                <>
                    <svg
                        className="animate-spin h-5 w-5 text-white"
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                    >
                        <circle
                            className="opacity-25"
                            cx="12"
                            cy="12"
                            r="10"
                            stroke="currentColor"
                            strokeWidth="4"
                        />
                        <path
                            className="opacity-75"
                            fill="currentColor"
                            d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                        />
                    </svg>
                    <span>Processing...</span>
                </>
            ) : (
                <span>Continue →</span>
            )}
        </button>
    );
};

export default SubmitButton;
