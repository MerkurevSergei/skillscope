export type BackendHealth = {
  status: string;
  service: string;
  timestamp: string;
};

const apiBaseUrl = import.meta.env.VITE_API_BASE_URL ?? '';

export async function getBackendHealth(): Promise<BackendHealth> {
  const response = await fetch(`${apiBaseUrl}/api/health`);

  if (!response.ok) {
    throw new Error(`Backend health check failed: ${response.status}`);
  }

  return response.json() as Promise<BackendHealth>;
}
