import React, { useEffect } from "react";

const Toast = ({ notification, onClose }) => {
    useEffect(() => {
        if (!notification) return;
        const timer = setTimeout(() => {
            onClose();
        }, 4200);
        return () => clearTimeout(timer);
    }, [notification, onClose]);

    if (!notification) return null;

    const isSuccess = notification.type === "success";

    return (
        <div className="fixed bottom-8 right-8 z-50 pointer-events-none select-none">
            <div className="relative">
                {/* Main Glass Toast (No Border, pure frosted glass) */}
                <div
                    className={`animate-toast-shatter pointer-events-auto flex items-center gap-3.5 px-6 py-4 rounded-3xl shadow-[0_25px_60px_rgba(0,0,0,0.12)] backdrop-blur-3xl min-w-[320px] max-w-md ${
                        isSuccess
                            ? "bg-white/85 text-slate-800 shadow-emerald-500/10"
                            : "bg-white/85 text-slate-800 shadow-rose-500/10"
                    }`}
                >
                    {/* Status Icon without any border or harsh box */}
                    <div
                        className={`text-xl font-black shrink-0 flex items-center justify-center w-8 h-8 ${
                            isSuccess ? "text-emerald-600" : "text-rose-600"
                        }`}
                    >
                        {isSuccess ? "✓" : "✕"}
                    </div>

                    {/* Message Details */}
                    <div className="flex-1 pr-2">
                        <p
                            className={`text-[11px] font-extrabold uppercase tracking-widest ${
                                isSuccess ? "text-emerald-700" : "text-rose-700"
                            }`}
                        >
                            {isSuccess ? "Success" : "Notification"}
                        </p>
                        <p className="text-sm font-medium text-slate-700 mt-0.5 leading-snug">
                            {notification.message}
                        </p>
                    </div>

                    {/* Close Action */}
                    <button
                        onClick={onClose}
                        className="text-slate-400 hover:text-slate-700 p-1 rounded-lg transition-colors cursor-pointer"
                    >
                        ✕
                    </button>
                </div>

                {/* Glass Shatter Shards (Kaanch ke tukde jo hawa me tut kar bikhar jaate hain) */}
                <div className="absolute inset-0 pointer-events-none overflow-visible">
                    <div className="shatter-shard-1 absolute top-2 left-4 w-7 h-5 bg-white/70 backdrop-blur-md rounded-tl-xl clip-triangle shadow-sm"></div>
                    <div className="shatter-shard-2 absolute top-1 right-8 w-6 h-6 bg-white/75 backdrop-blur-md rounded-br-lg shadow-sm"></div>
                    <div className="shatter-shard-3 absolute bottom-2 left-10 w-8 h-4 bg-white/60 backdrop-blur-md rounded-tr-lg shadow-sm"></div>
                    <div className="shatter-shard-4 absolute bottom-3 right-6 w-5 h-7 bg-white/70 backdrop-blur-md rounded-bl-xl shadow-sm"></div>
                    <div className="shatter-shard-5 absolute top-1/2 left-1/2 w-4 h-4 bg-white/80 backdrop-blur-md rounded-full shadow-sm"></div>
                </div>
            </div>
        </div>
    );
};

export default Toast;

